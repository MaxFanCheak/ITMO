package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    Scanner sc;
    public int winToEnd,m,n,k;
    public Input(){
        sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the numbers of matches: ");
                winToEnd = sc.nextInt();
                if (!sc.nextLine().isEmpty()) {
                    throw new InputAmountOfNumbersException(
                            "To many parameters to game!\nEnter 1th parameters, please");
                }
                if (winToEnd < 1) {
                    throw new InputNegativesNumbersException(
                            "Number of matches must be above zero, but you entered: " + winToEnd + "\nRe-enter, please");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid numbers of matches!\nRe-enter, please");
                if(sc.hasNextLine()) {
                    sc.nextLine();
                }
                continue;
            } catch (InputNegativesNumbersException | InputAmountOfNumbersException er) {
                System.err.println(er.getMessage());
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Enter parameters of the board and count of tokens to win: ");
                n = sc.nextInt();
                m = sc.nextInt();
                if (Math.min(n,m) < 1) {
                    throw new InputNegativesNumbersException(
                            "Size of board must be above zero, but you entered: " + m +" " + n + "\nRe-enter, please");
                }
                while (true) {
                    try {
                        k = sc.nextInt();
                        if (k < 1) {
                            throw new InputNegativesNumbersException(
                                    "Tokens to win must be above zero, but you entered: " + k + "\nRe-enter, please");
                        }
                        if (!sc.nextLine().isEmpty()) {
                            throw new InputAmountOfNumbersException(
                                    "To many parameters to game!\nEnter 3th parameters please");
                        }
                        if (k > Math.max(m, n)) {
                            throw new InputNegativesNumbersException(
                                    "Number of tokens to win must be less or equal " + Math.max(m, n) + ", but you entered: " + k + "\nRe-enter, please");
                        }
                    } catch (InputNegativesNumbersException | InputAmountOfNumbersException e) {
                        System.err.println(e.getMessage());
                        continue;
                    } catch (InputMismatchException er) {
                        System.err.println("Invalid tokens to win, tokens must be integer!\nRe-enter, please");
                        sc.nextLine();
                        continue;
                    }
                    break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid size of board!\nRe-enter, please");
                sc.next();
                continue;
            }catch (InputNegativesNumbersException e) {
                System.err.println(e.getMessage());
                continue;
            }
            break;
        }

    }
}
