ArrayList<Integer> cardCompare(String card1, String card2) {
    int value1 = card1.charAt(0) - '0';
    int value2 = card2.charAt(0) - '0';
    String suit1 = card1.substring(1);
    String suit2 = card2.substring(1);

    int suitOrder1 = "HCD S".indexOf(suit1);
    int suitOrder2 = "HCD S".indexOf(suit2);

    if (suitOrder1 < suitOrder2) return new ArrayList<Integer>(Arrays.asList(-1));
    else if (suitOrder1 > suitOrder2) return new ArrayList<Integer>(Arrays.asList(1));
    else if (value1 < value2) return new ArrayList<Integer>(Arrays.asList(-1));
    else if (value1 > value2) return new ArrayList<Integer>(Arrays.asList(1));
    else return new ArrayList<Integer>(Arrays.asList(0));
}






ArrayList<String> bubbleSort(ArrayList<String> array) {
    for (int i = 0; i < array.size() - 1; i++) {
        for (int j = 0; j < array.size() - i - 1; j++) {
            int result = cardCompare(array.get(j), array.get(j + 1)).get(0);
            if (result > 0) {
                Collections.swap(array, j, j + 1);
            }
        }
    }
    return array;
}









ArrayList<String> mergeSort(ArrayList<String> array) {
    if (array.size() <= 1) return array;
    ArrayList<String> left = new ArrayList<>(array.subList(0, array.size() / 2));
    ArrayList<String> right = new ArrayList<>(array.subList(array.size() / 2, array.size()));
    left = mergeSort(left);
    right = mergeSort(right);
    return merge(left, right);
}

ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right) {
    ArrayList<String> result = new ArrayList<>();
    int indexLeft = 0, indexRight = 0;
    while (indexLeft < left.size() && indexRight < right.size()) {
        int compareResult = cardCompare(left.get(indexLeft), right.get(indexRight)).get(0);
        if (compareResult <= 0) {
            result.add(left.get(indexLeft++));
        } else {
            result.add(right.get(indexRight++));
        }
    }
    while (indexLeft < left.size()) {
        result.add(left.get(indexLeft++));
    }
    while (indexRight < right.size()) {
        result.add(right.get(indexRight++));
    }
    return result;
}









long measureBubbleSort(String filename) throws IOException {
    long startTime = System.currentTimeMillis();
    ArrayList<String> cards = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            cards.add(line);
        }
    }
    bubbleSort(cards);
    return System.currentTimeMillis() - startTime;
}










long measureMergeSort(String filename) throws IOException {
    long startTime = System.currentTimeMillis();
    ArrayList<String> cards = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            cards.add(line);
        }
    }
    mergeSort(cards);
    return System.currentTimeMillis() - startTime;
}











void sortComparison(String[] filenames) throws IOException {
    try (PrintWriter out = new PrintWriter("sortComparison.csv")) {
        out.println(", " + filenames[0].split("\\.")[0] + ", " + filenames[1].split("\\.")[0] + ", " + filenames[2].split("\\.")[0]);
        out.println("bubbleSort, " + measureBubbleSort(filenames[0]) + ", " + measureBubbleSort(filenames[1]) + ", " + measureBubbleSort(filenames[2]));
        out.println("mergeSort, " + measureMergeSort(filenames[0]) + ", " + measureMergeSort(filenames[1]) + ", " + measureMergeSort(filenames[2]));
    }
}










