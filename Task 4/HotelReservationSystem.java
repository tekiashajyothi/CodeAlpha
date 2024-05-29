import java.util.Scanner;

class HotelReservationSystem {
    private static Room[] rooms;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        System.out.println("Thank you for using our hotel reservation system!");
    }

    private static void initializeRooms() {
        rooms = new Room[5];
        rooms[0] = new Room(101, RoomType.SINGLE, 50);
        rooms[1] = new Room(102, RoomType.DOUBLE, 80);
        rooms[2] = new Room(103, RoomType.SUITE, 120);
        rooms[3] = new Room(104, RoomType.PENTHOUSE, 200);
        rooms[4] = new Room(105, RoomType.SINGLE, 50);
    }

    private static void searchRooms() {
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber && !room.isBooked()) {
                room.book();
                System.out.println("Reservation successful.");
                return;
            }
        }
        System.out.println("Room not available or invalid room number.");
    }

    private static void viewBookingDetails() {
        System.out.println("Booking details:");
        for (Room room : rooms) {
            if (room.isBooked()) {
                System.out.println(room);
            }
        }
    }
}

class Room {
    private int number;
    private RoomType type;
    private double price;
    private boolean booked;

    public Room(int number, RoomType type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.booked = false;
    }

    public int getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    @Override
    public String toString() {
        return "Room number: " + number +
                ", Type: " + type +
                ", Price: $" + price +
                ", Booked: " + (booked ? "Yes" : "No");
    }
}

enum RoomType {
    SINGLE, DOUBLE, SUITE, PENTHOUSE
}
