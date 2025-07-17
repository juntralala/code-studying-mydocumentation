package com.ujun;


public class Main {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

//    public static void testShowTodoList() {
//        model[0] = "Tidur";
//        model[1] = "Belajar";
//        model[3] = "Tugas delphi";
//        showTodoList();
//    }

    /**
     * menambah todo list
     */
    public static void addTodoList (String todo) {
        // cek apakah model penuh
        var isFull = true;
        for (var i = 0; i< model.length ; i++) {
            // model masih ada yang kosong
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2X lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i<temp.length ; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan keposisi data yang array nya null
        for (var i = 0; i<model.length ; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
    public static void testAddTodoList() {

        for (var i = 0; i < 25 ; i++) {
            addTodoList("Todo ke- " + (i + 1));
        }
//        showTodoList();
        System.out.println(model.length);
    }

    /**
     * menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if (((number - 1) >= model.length) || (model[number - 1] == null)) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length ; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
    public static void testRemoveTodoList() {
        addTodoList("Tidur Jam 8 malam");
        addTodoList("Belajar bahasa python");
        addTodoList("Belajar bahasa Java");
        addTodoList("Belajar bahasa PHP");
        var removed = removeTodoList(2);
        removeTodoList(3);

//        showTodoList();
        System.out.println(removed);
    }

    /**
     * menerima input user
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }
    public static void tesInput() {
        var nama = input("Nama");
        var umur = input("Umur");
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
    }

    /**
     * menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            System.out.println("TODO");
//            showTodoList();

            System.out.println("<--- Menu --->");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");
            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
    public static void tesViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("empat");
        viewShowTodoList();
    }

    /**
     * menampilkan view menambah todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }
    public static  void tesViewAddTodoList() {
        addTodoList("Belajar java");
        addTodoList("Mnjadi orang yang bermanfaat");

        viewAddTodoList();
//        showTodoList();
    }

    /**
     * menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("Mengahapus todo list".toUpperCase());

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            System.out.println("Gagal menghapus todolist ini : " + number);
        }
    }
    public static void tesViewRemoveTodoList(){
        addTodoList("Belajar java");
        addTodoList("Mnjadi orang yang bermanfaat");
        addTodoList("Berbakti kepada orangtua");
        addTodoList("Menyenangkan hati idolaku");

//        showTodoList();
        viewRemoveTodoList();
//        showTodoList();

    }

}
