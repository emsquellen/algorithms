// Doesn't work yet
async function doubleSelectionSort(elements) {
    let n = elements.length;
    let min, max;
    let left = 0;
    let right = n - 1;
    while (left <= right) {
        min = left;
        max = right;
        for (let i = left + 1; i < right; i++) { // O(n)
            if (getValue(i) < getValue(min)) {
                min = i;
            }
        }
        if (min != left) {
            await swap(left, min);

        }
        for (let j = right - 1; j > left; j--) { // O(n)
            if (getValue(j) > getValue(max)) {
                max = j;
            }
        }
        if (max != right) {
            await swap(right, max);

        }
        left++;
        right--;
    }
}
