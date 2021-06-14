function isMonotonic(arr) {
  // Write your code here.
	if (arr.length <= 2) return true;
	let isNonIncreasing = false; isNonDecreasing = false;
	for (let i = 0; i < arr.length - 1; i++) {
		const numsDiff = arr[i + 1] - arr[i];
		if ((isNonIncreasing && numsDiff > 0) 
				|| (isNonDecreasing && numsDiff < 0))
			return false;
		isNonIncreasing = numsDiff < 0 ? true : isNonIncreasing;
		isNonDecreasing = numsDiff > 0 ? true : isNonDecreasing;
	}
	return true;
}

// Do not edit the line below.
exports.isMonotonic = isMonotonic;
