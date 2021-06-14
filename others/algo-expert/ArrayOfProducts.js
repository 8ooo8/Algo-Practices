function longestPeak(arr) {
  // Write your code here.
	if (arr.length < 3) return 0;
	let maxPeak = trough = i = 0;
	let isPeak = false;
	while (i < arr.length - 1) {
		trough = i;
		isPeak = false;
		if (_isIncreasing(arr[i], arr[i + 1])) {
			do {
				i++;
			} while (_isIncreasing(arr[i], arr[i + 1]) && i < arr.length - 1);
			if (_isDecreasing(arr[i], arr[i + 1])) { // when increase first then decrease
				isPeak = true;
				do {
					i++;
				} while (_isDecreasing(arr[i], arr[i + 1]) && i < arr.length - 1);
			}
		}
		if (isPeak)
			maxPeak = Math.max(maxPeak, (_isDecreasing(arr[i], arr[i + 1]) ? i + 1 : i) - trough + 1);
		else
			i++;
	}
	
	return maxPeak;
}

const _isIncreasing = (a, b) => b > a;
const _isDecreasing = (a, b) => a > b;

// Do not edit the line below.
exports.longestPeak = longestPeak;
