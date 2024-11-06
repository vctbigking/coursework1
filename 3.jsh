int[] prices = {80, 38, 65};

while (true) {
    System.out.println("Would you like (v)anilla, (c)hocolate or (s)trawberry?");
    String flavour = System.console().readLine().toLowerCase();

    if (!"v".equals(flavour) && !"c".equals(flavour) && !"s".equals(flavour)) {
        System.out.println("We don't have that flavour.");
        continue;
    }

    System.out.println("How many scoops would you like?");
    int scoops = Integer.parseInt(System.console().readLine());

    if (scoops < 1) {
        System.out.println("We don't sell just a cone.");
        continue;
    } else if (scoops > 3) {
        System.out.println("That's too many scoops to fit in a cone.");
        continue;
    }

    int pricePerScoop = prices["v".equals(flavour) ? 2 : "c".equals(flavour) ? 1 : 0];
    int totalCost = 100 + (pricePerScoop * scoops);
    int pounds = totalCost / 100;
    int pence = totalCost % 100;
    System.out.println("That will be " + pounds + "." + String.format("%02d", pence) + "00 please.");
}