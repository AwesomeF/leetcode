public class DistributeCandies {

    public static void main(String[] args) {

        int candies = 1000;
        int people = 10;

        int[] result = giveCandies(candies, people);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(" input candies or num_people invalid");
        }

    }

    private static int[] giveCandies(int candies, int people) {
//        1 <= candies <= 10^9
//        1 <= num_people <= 1000
        if (people < 1 || people > 1000 || candies < 1) {
            return null;
        }
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
