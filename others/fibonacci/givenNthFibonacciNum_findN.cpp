#include <stdio.h>
#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

/*
 ----------------------------
 |Time Complexity:  O(log n)|
 |Space Complexity: O(log n)|
 ----------------------------

 ======== Solution ========
 Let Fn the n-th fabonacci number.
 Fn = Fn-1 + Fn-2 -- (1)

 Solve (1) recursively:
 Fn = (Fn-2 + Fn-3) + Fn-2 = 2Fn-2 + Fn-3
    = 2(Fn-3 + Fn-4) + Fn-3 = 3Fn-3 + 2Fn-4
    = ... = xp*Fp-1 + yp*Fp, where n > p, p-1 >= 1, xp and yp are positive integers
 
 Let Rn-p = {n-p, xp, yp} = {d, xp, yp}, where d = n-p.
                        
 Assume we have Rn, Rn+1, Rn+2:
 Rn   = {n,    x,  y}, i.e. Fn+2 = x*F1 + y*F2 (e.g. n, x and y all equal 1, then F3 = F1 + F2).
 Rn+1 = {n+1, x1, y1}, i.e. Fn+3 = x1*F1 + y1*F2,
 Rn+2 = {n+2, x2, y2}, i.e. Fn+4 = x2*F1 + y2*F2.
 Then, R2n+3, R2n+4, R2n+5 can be attained by formulae:
 (1) F2n+5 = x2*Fn+2 + y2*Fn+3 = x2*(x*F1 + y*F2) + y2*(x1*F1 + y1*F2)
 = (x2*x + y2*x1) * F1 + (x2*y + y2*y1) * F2
 <-> R2n+3 = {2n+3, x2*x + y2*x1, x2*y + y2*y1}
 (2) F2n+6 = x2*Fn+3 + y2*Fn+4 = x2*(x1*F1 + y1*F2) + y2*(x2*F1 + y2*F2)
 = (x2*x1 + y2*x2) * F1 + (x2*y1 + y2*y2) * F2 
 <-> R2n+4 = {2n+4, x2*x1 + y2*x2, x2*y1 + y2*y2}
 (3) F2n+7 = F2n+5 + F2n+6 
 <-> R2n+5 = {2n+5, R2n+3.x + R2n+4.x, R2n+3.y + R2n+4.y}

 Repeat the above process to get R with larger and larger d 
 and jump from a fibonacci number to a much larger fibonacci number using the R.
 When a fibonacci number larger than the user input number is found, the user input number should
 sit between the largest fibonacci number found and the previously found largest fibonacci number.
 Perform a binary search within the above number range to obtain the solution.
 */
typedef unsigned long long int ull;
struct R{
    int d; ull x, y;
    R(int d, ull x, ull y):d(d),x(x),y(y){}
};
struct RSet{
    R r, r2, r3; //r has the smallest d; r2's d = r's d + 1; r3's d = r's d + 2
    RSet(R r, R r2, R r3):r(r),r2(r2),r3(r3){}
};
struct Fn{
    int n; ull fn;
    Fn(){}
    Fn(int n, ull fn):n(n),fn(fn){}
    Fn* setN(int n){ this->n = n; return this; }
    Fn* setFn(ull fn){ this->fn = fn; return this; }
};
typedef struct FnSet{
    Fn fn, fn2, fn3; //n = n2 - 1 = n3 - 2
    FnSet(){}
    FnSet(Fn fn, Fn fn2, Fn fn3):fn(fn),fn2(fn2),fn3(fn3){}
    FnSet* setFn(Fn fn){ this->fn = fn; return this; }
    FnSet* setFn2(Fn fn2){ this->fn2 = fn2; return this; }
    FnSet* setFn3(Fn fn3){ this->fn3 = fn3; return this; }
} Bound; //the boundaries of the binary search area.

vector<RSet> rSetList;
int idxOfRForNextBSMiddle; //the index of the R used to find the middle point of the next binary search area
Bound lowerBound, upperBound;


void resetRSetListAndBounds();
Bound getNewBound(const Bound &baseBound, const RSet &rSet);
void pushBoundsForward();
int getNOfGivenFn(const ull fn);
int getNOfGivenFnByBinarySearch(const ull fn);

//A quick test on the implemented functions
int main(){
    cout << getNOfGivenFn(1) << endl; //1
    cout << getNOfGivenFn(1779979416004714189) << endl; //89
    cout << getNOfGivenFn(832040) << endl; //30
    cout << getNOfGivenFn(1) << endl; //1
    cout << getNOfGivenFn(2) << endl; //3
    cout << getNOfGivenFn(1) << endl; //1
    return 0;
}

void resetRSetListAndBounds(){
    rSetList.clear();
    rSetList.push_back(RSet(R(1, 1, 1), R(2, 1, 2), R(3, 2, 3)));
    lowerBound.setFn(Fn(1, 1))->setFn2(Fn(2, 1))->setFn3(Fn(3, 2));
    upperBound = lowerBound; //note: it is a copy but not a referencing
}

Bound getNewBound(const Bound &baseBound, const RSet &rSet){
    //Using r3 of the rSet to obtain the new bound, instead of using r2 or r1, would lead to an
    //incomplete coverage of the binary search.
    //For instance, in a binary serach, the search target n is 260 and its Fn is 1779979416004714189.
    //Using r3 during the search would finally lead to a lowerBound
    //having Fns of n=257, n=258 and n=259 and an upperBound having Fns of n=261, n=262, n=263.
    //To jump from the lowerBound to the target n, 260, it needs a R with d=1 or d=2.
    //However, among all rSets, the smallest r3 has a d=3.
    //Therefore, r3 is not an appropriate option even though it allows a jump of longer distance.
    const R r = rSet.r2;
    const int n = baseBound.fn.n;
    const ull baseFn = baseBound.fn.fn, baseFnPlus1 = baseBound.fn2.fn, baseFnPlus2 = baseBound.fn3.fn;
    const int d = r.d;
    const ull x = r.x, y = r.y;
    Fn new1stFn = {d + n + 1, x * baseFn + y * baseFnPlus1};
    Fn new2ndFn = {d + n + 2, x * baseFnPlus1 + y * baseFnPlus2};
    Fn new3rdFn = {d + n + 3, new1stFn.fn + new2ndFn.fn};
    return Bound(new1stFn, new2ndFn, new3rdFn);
}

void pushBoundsForward(){
    //Generate R with greater d and make use of them to generate larger fibonacci numbers
    //which will be set as the new upper bound of the binary search
    const RSet rSetWithMaxD = rSetList.back();
    const R rn = rSetWithMaxD.r, rnPlus1 = rSetWithMaxD.r2, rnPlus2 = rSetWithMaxD.r3;
    const int d = rn.d;
    const ull x = rn.x, y = rn.y, x1 = rnPlus1.x, y1 = rnPlus1.y, x2 = rnPlus2.x, y2 = rnPlus2.y;
    R r2nPlus3 = {2*d + 3, x2*x + y2*x1, x2*y + y2*y1};
    R r2nPlus4 = {2*d + 4, x2*x1 + y2*x2, x2*y1 + y2*y2};
    R r2nPlus5 = {2*d + 5, r2nPlus3.x + r2nPlus4.x, r2nPlus3.y + r2nPlus4.y};
    RSet newRSet(r2nPlus3, r2nPlus4, r2nPlus5);
    rSetList.push_back(newRSet);
    
    //Push the bounds of the binary search area forward.
    lowerBound = upperBound;
    upperBound = getNewBound(upperBound, newRSet);
    
    idxOfRForNextBSMiddle = rSetList.size() - 2;
}

//When Fn is 1, 1, not 2, will be returned.
int getNOfGivenFn(const ull fn){
    resetRSetListAndBounds();
    lowerBound.setFn(Fn(1, 1))->setFn2(Fn(2, 1))->setFn3(Fn(3, 2));
    int result;
    while ((result = getNOfGivenFnByBinarySearch(fn)) < 1){
        pushBoundsForward();
    }
    return result;
}

int getNOfGivenFnByBinarySearch(const ull fn){
    //Fn out of bounds
    if ((lowerBound.fn.fn > fn) || (upperBound.fn.fn < fn))
        return -1;
    
    //Fn on bounds
    int result;
    bool fnIsOnBound = false;
    auto getNIfFnOnBound = [&](Bound bound){
        if (bound.fn.fn == fn) { fnIsOnBound = true; result = bound.fn.n; }
        else if (bound.fn2.fn == fn) { fnIsOnBound = true; result = bound.fn2.n; }
        else if (bound.fn3.fn == fn) { fnIsOnBound = true; result = bound.fn3.n; }
    };
    getNIfFnOnBound(lowerBound);
    getNIfFnOnBound(upperBound);
    if (fnIsOnBound) return result;
    
    //Fn in bounds
    auto getRBestForNextBSMiddle = [&](){
        int idxOfNewRCandidate = idxOfRForNextBSMiddle - 1;
        if (idxOfNewRCandidate < 0) return idxOfRForNextBSMiddle;
        
        int dOfRForBSMiddle = rSetList.at(idxOfRForNextBSMiddle).r2.d;
        int dOfNewRCandidate = rSetList.at(idxOfNewRCandidate).r2.d;
        double middlePoint = (upperBound.fn.n - lowerBound.fn3.n) / 2.0;
        if (dOfNewRCandidate >= 0 &&
            abs(dOfNewRCandidate - middlePoint) < abs(dOfRForBSMiddle - middlePoint))
            return idxOfNewRCandidate;
        else
            return idxOfRForNextBSMiddle;
    };
    idxOfRForNextBSMiddle = getRBestForNextBSMiddle();
    Bound middlePoint = getNewBound(lowerBound, rSetList.at(idxOfRForNextBSMiddle));
    if (middlePoint.fn.fn < fn)
        lowerBound = middlePoint;
    else
        upperBound = middlePoint;
    return getNOfGivenFnByBinarySearch(fn);
}
