//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        You may assume nums1 and nums2 cannot be both empty.
//
//        Example 1:
//
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5
//
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longer = nums1;
        int[] shorter = nums2;
        if (longer.length < shorter.length) {
            longer = nums2;
            shorter = nums1;
        }
        int m = longer.length;
        int n = shorter.length;
        if (m == 1 && n == 1) return (nums1[0] + nums2[0]) / 2.0;
        int i = 0;
        int j = n;
        int countFromSmall = (i + j) / 2;
        int countFromLarge = ((m + n) / 2) - countFromSmall;
        while (true) {
            int a1 = Integer.MIN_VALUE;
            int a2 = Integer.MIN_VALUE;
            int b1 = Integer.MAX_VALUE;
            int b2 = Integer.MAX_VALUE;
            if (countFromSmall > 0 && countFromSmall <= n) {
                a1 = shorter[countFromSmall - 1];
            }
            if (countFromSmall >= 0 && countFromSmall < n) {
                b1 = shorter[countFromSmall];
            }
            if (countFromLarge > 0 && countFromLarge <= m) {
                a2 = longer[countFromLarge - 1];
            }
            if (countFromLarge >= 0 && countFromLarge < m) {
                b2 = longer[countFromLarge];
            }
            if (a1 == b2) return a1;
            if (a2 == b1) return a2;
            if (a1 < b2 && a2 < b1) {
                if (isEven(m + n)) {
                    return (Math.max(a1, a2) + Math.min(b1, b2)) / 2.0;
                }
                return Math.max(Math.max(a1, a2), Math.min(b1, b2));
            }
            if (a1 > b2) {
                j = countFromSmall - 1;
            } else {
                i = countFromSmall + 1;
            }
            countFromSmall = (i + j) / 2;
            countFromLarge = ((m + n) / 2) - countFromSmall;

        }
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

}