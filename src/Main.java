import java.util.Scanner;
import Task.*;

public class Main {
    private static final TaskService taskService = new TaskService();

    public Main() {
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            try {
                label41:
                while(true) {
                    while(true) {
                        printMenu();
                        System.out.println("Выберите команду: ");
                        if (scanner.hasNextInt()) {
                            int menu = scanner.nextInt();
                            switch (menu) {
                                case 0:
                                    System.out.println("досвидания");
                                    break label41;
                                case 1:
                                    add();
                                    break;
                                case 2:
                                    remove();
                                    break;
                                case 3:
                                    listTaskMap();
                                    break;
                                case 4:
                                    findTask();
                                    break;
                                default:
                                    System.out.println(" Ошибка пункта меню");
                                    System.out.println(" Выберите пункт меню из списка!");
                            }
                        } else {
                            scanner.next();
                        }
                    }
                }
            } catch (Throwable var5) {
                try {
                    scanner.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            scanner.close();
        } catch (TaskNotFoundException var6) {
            System.out.println(var6.getMessage());
        } catch (DescriptionField var7) {
            System.out.println(var7.getArgument());
        }

    }

    private static void printMenu() {
        System.out.println("Доступные команды: \n 1. Добавить задачу \n 2. Удалить задачу  \n 3. Показать список задач \n 4. Найти задачу \n 0. Выход");
    }

    private static void add() throws DescriptionField {
        System.out.println(" Выберите периодичность задачи: ");
        Repeatability[] var0 = Repeatability.values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Repeatability Repeatability = var0[var2];
            System.out.println(Repeatability);
        }

        String strPeriodicity = InputUtils.askString("Ваш выбор").toUpperCase();
        Repeatability repeatability = Repeatability.valueOf(strPeriodicity);
        taskService.add(repeatability);
    }

    private static void remove() throws TaskNotFoundException {
        int id = InputUtils.askInt("Введите идентификатор задачи, которую вы хотите удалить");
        taskService.remove(id);
    }

    private static void listTaskMap() {
        taskService.listTaskMap();
    }

    private static void findTask() {
        String substr = InputUtils.askString("Введите строку, чтобы найти");
        taskService.findTask(substr);
    }
}