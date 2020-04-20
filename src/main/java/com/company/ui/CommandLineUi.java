package com.company.ui;

import com.company.service.MoveObjectService;
import com.company.service.MoveObjectServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class CommandLineUi {

    MoveObjectService movingService = new MoveObjectServiceImpl();

    public static void main(String[] args) {
        (new CommandLineUi()).runSimulation();
    }

    void runSimulation() {

        Scanner scanner = new Scanner(System.in);

        readInitialParameters(scanner);

        printMenu();

        String[] commands = scanner.nextLine().split(",");

        Arrays.stream(commands).map(Integer::valueOf)
                .filter(code -> checkValidCommand(code))
                .forEach(commandCode ->
                {
                    boolean isExit = movingService.handleCommand(commandCode);

                    if (isExit) {
                        System.out.println(movingService.retrievePosition());
                        return;
                    }
                });
    }

    private void readInitialParameters(Scanner scanner) {
        System.out.print("Enter initial parameters (height, width, x position, y position) >");

        String[] initParams = scanner.nextLine().split(",");

        int height = Integer.valueOf(initParams[0]);
        int width = Integer.valueOf(initParams[1]);
        int x = Integer.valueOf(initParams[2]);
        int y = Integer.valueOf(initParams[3]);

        movingService.initTable(height, width, x, y);
    }

    private void printMenu() {
        System.out.print("Enter commands\n" +
                "0 = quit simulation and print results to stout\n" +
                "1 = move forward one step\n" +
                "2 = move backwards one step\n" +
                "3 = rotate clockwise 90 degrees (eg north to east)\n" +
                "4 = rotate counterclockwise 90 degrees (eg west to south)\n" +
                ">");
    }

    boolean checkValidCommand(int code) {
        if (code >= 0 && code <= 4) {
            return true;
        } else {
            System.out.println("Error code " + code + " would be ignored.");
            return false;
        }
    }
}
