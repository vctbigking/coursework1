void display(int n) {
    if (n > 99) {
        System.out.println("Number too large. Maximum is 99.");
        return;
    }
    int ones = n % 10;
    int tens = n / 10;

    for (int line = 1; line <= 5; line++) {
        String top = (tens > 0) ? ssd(tens, line) : (line == 1 || line == 2 ? " -- " : "     ");
        String middle = (tens > 0 && ones > 0) ? " | " : "   ";
        String bottom = ssd(ones, line);
        System.out.println(top + middle + bottom);
    }
    for (int line = 6; line <= 7; line++) {
        String top = ssd(ones, line);
        String middle = (tens > 0 && ones > 0) ? " | " : "   ";
        String bottom = (tens > 0) ? ssd(tens, line) : "     ";
        System.out.println(top + middle + bottom);
    }
}
String ssd(int d, int n) {
    switch ((d * 10) + n) {
        case  1: case  5: case 21: case 23: case 25: case 31: case 33: case 35:
        case 43: case 51: case 53: case 55: case 61: case 63: case 65: case 71:
        case 81: case 83: case 85: case 91: case 93: case 95:
            return " --  ";
        case 24: case 52: case 62:
            return "|    ";
        case 12: case 14: case 22: case 32: case 34: case 44: case 54: case 72:
        case 74: case 94:
            return "   | ";
        case  2: case  4: case 42: case 64: case 82: case 84: case 92:
            return "|  | ";
        default: return "     ";
    }
}
display(28); 

