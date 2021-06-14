function firstDuplicateValue(array) {
  // Write your code here.
	for (const num of array) {
		const absNum = Math.abs(num);
		if (array[absNum - 1] < 0) return absNum;
		array[absNum - 1] *= -1;
	}
	return -1;
}

// Do not edit the line below.
exports.firstDuplicateValue = firstDuplicateValue;
