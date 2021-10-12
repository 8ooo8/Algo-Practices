def solution(s):
    # Your code here

    # O(n logn) time complexity

    # Assume that there is a good slicing (here "good slicing" refers to any slicing which gives the requested max number).
    # Then, another good slicing can be obtained by moving the cuts of the cake one M&M leftward,
    # e.g. original good slicing: [ABC] [ABC] -> [A][BC] [A][BC] -> [CAB] [CAB].
    # Then, by repeating the above step, we can have a good slicing in which every slice has s[0] M&M as its rightmost M&M.

    numOfMs = len(s) # the total number of the M&Ms
    rightmostMsInSlices = [0] # a list storing the rightmost M&Ms in the slices in anti-clockwise order
    for i in range(-1, -numOfMs, -1):
        if (s[i] == s[0]):
            rightmostMsInSlices.append(i) # slicing the cake at s[0] M&Ms.
    originalNumOfSlices = len(rightmostMsInSlices)

    # A good slicing can be obtained by removing some of the cuts of the cake in the above slicing,
    # i.e. concatenating some of the consecutive slices.
    # Iterate through s to find out the good slicing.

    if originalNumOfSlices == 1:
        return 1

    numOfConcatSlices = 0
    nextMToVisit = [-1] + range(-numOfMs, -1, 1)
    try: 
        while numOfMs != originalNumOfSlices / (numOfConcatSlices + 1) * (-nextMToVisit[0]) and numOfConcatSlices + 1 < originalNumOfSlices:
            nextMToVisitBy1stSlice = nextMToVisit[0]
            needConcat = nextMToVisitBy1stSlice == rightmostMsInSlices[1 + numOfConcatSlices] # true if the 1st slice about to overlap with the 2nd slice
            if needConcat:
                numOfConcatSlices += 1
                while originalNumOfSlices % (numOfConcatSlices + 1):
                    numOfConcatSlices += 1
            else:
                visitedMs = s[nextMToVisitBy1stSlice]
                for i in range (1 + numOfConcatSlices, originalNumOfSlices, 1 + numOfConcatSlices):
                    nextSliceRightmostM = rightmostMsInSlices[i]
                    nextMToVisitByNextSlice = nextMToVisit[nextSliceRightmostM]
                    visitedMs += s[nextMToVisitByNextSlice]
                    if s[nextMToVisitBy1stSlice] == s[nextMToVisitByNextSlice]:
                        nextMToVisit[nextSliceRightmostM] = nextMToVisit[nextMToVisitByNextSlice]
                    else:
                        needConcat = True
                nextMToVisit[0] = nextMToVisit[nextMToVisitBy1stSlice]
                if (needConcat):
                    numOfConcatSlices = len(visitedMs) / solution(visitedMs) * (1 + numOfConcatSlices) - 1
    except IndexError:
        return 1

    return originalNumOfSlices / (numOfConcatSlices + 1)
