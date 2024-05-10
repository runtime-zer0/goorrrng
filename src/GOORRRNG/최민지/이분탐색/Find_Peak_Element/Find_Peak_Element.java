class Solution {
  public int findPeakElement(int[] nums) {
      
      // edge case
      if(nums.length == 1) return 0;

      int n = nums.length;
      if(nums[0] > nums[1]) return 0;
      if(nums[n-1] > nums[n-2]) return n-1;

      // 나머지 범위 이분 탐색
      int start = 1;
      int end = n - 2;
      int mid = 0;

      while(start < end){
        mid  = start + (end - start)/2;
        if(nums[mid] < nums[mid+1]) start = mid + 1; // mid는 peek가 될 수 없기 때문에 start 이동
        else end = mid; // 그렇지 않다면 mid가 peek가 될 가능성이 있기 때문에 end
      }

      return start;
  }
}
