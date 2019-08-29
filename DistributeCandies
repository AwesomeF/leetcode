public class DistributeCandies {

    public static void main(String[] args) {

        int candies = 1000;
        int people = 20;

        int[] result = giveCandies(candies, people);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] giveCandies(int candies, int people) {
        int currentCount = 1;
        int peopleIndex = 0;
        int currentLeft = candies;
        int[] result = new int[people];
        while (currentLeft > 0) {
            int listIndex = peopleIndex % people;
            if (currentLeft > currentCount) {
                result[listIndex] = result[listIndex] + currentCount;
                currentLeft = currentLeft - currentCount;
            } else {
                result[listIndex] = result[listIndex] + currentLeft;
                currentLeft = 0;
            }
            peopleIndex++;
            currentCount++;
        }
        return result;
    }
}
