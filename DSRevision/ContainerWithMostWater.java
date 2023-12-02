public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater.maxArea(height));
    }

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while(leftIndex < rightIndex) {
            int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            maxArea = Math.max(maxArea, area);
            if(height[leftIndex] < height[rightIndex])
                leftIndex ++;
            else 
                rightIndex --;
        }
        return maxArea;
    }
    
}
