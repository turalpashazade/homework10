void main() {
    Scanner scanner = new Scanner(System.in);

    runTask1(scanner);
    runTask2(scanner);
    runTask3();

    scanner.close();
}

private static void runTask1(Scanner scanner) {
    IO.println("Task 1: Integer daxil edin, kvadratını hesablayım.");

    while (true) {
        IO.print("Bir tam eded daxil edin: ");
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            int square = number * number;
            IO.println("Kvadrati: " + square);
            break;
        } catch (NumberFormatException e) {
            IO.println("Xeta: Duzgun tam eded daxil edin.");
        }
    }
}

private static void runTask2(Scanner scanner) {
    IO.println("\nTask 2: Yas deyeri daxil edin (0 - 120 araliginda olmalidir).");

    while (true) {
        IO.print("Yas daxil edin: ");
        String input = scanner.nextLine();

        try {
            int age = Integer.parseInt(input);
            validateAge(age);
            IO.println("Duzgun yas daxil edildi: " + age);
            break;
        } catch (NumberFormatException e) {
            IO.println("Xeta: Yas tam eded olmalidir.");
        } catch (InvalidInputException e) {
            IO.println("Xeta: " + e.getMessage());
        }
    }
}

private static void validateAge(int age) throws InvalidInputException {
    if (age < 0 || age > 120) {
        throw new InvalidInputException("Yas 0 ile 120 arasinda olmalidir.");
    }
}

private static void runTask3() {
    IO.println("\nTask 3: Iki thread 1-den 8-e qeder ededleri cap edir.");

    Thread t1 = new NumberPrinterThread("Thread 1");
    Thread t2 = new NumberPrinterThread("Thread 2");

    t1.start();
    t2.start();

    try {
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        IO.println("Thread icrasi yarimciq qaldi.");
    }
}
