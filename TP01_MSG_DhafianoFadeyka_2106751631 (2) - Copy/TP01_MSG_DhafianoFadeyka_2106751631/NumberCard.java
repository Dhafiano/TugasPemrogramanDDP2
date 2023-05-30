// Dhafiano Fadeyka Ghani Wiweko
// 2106751631
// DDP 2 A
// TP1

import javax.swing.JOptionPane;
import java.lang.Math;


public class NumberCard{
 public static void main(String[] args) {
 String phrase; // a string of characters
 // other variables
 // Read in a string and find its length

 // Pembuatan string pada home GUI
 phrase = JOptionPane.showInputDialog(null,
 "Enter a credit card / debit card number as a long integer, Quit to end:\n",
 "Validation of Credit Card / Debit Card Numbers", JOptionPane.PLAIN_MESSAGE);

 
// Ketika ingin keluar dari aplikasi
 while (!phrase.equals("quit")) { //while the phrase is not equal to â€œquitâ€
    long number = Long.parseLong(phrase);
    boolean isValid = isValid(number);

    // Membuat system print dari masing-masing method
    System.out.println(getPrefix(number, 3));
    System.out.println(reverse(0));
    System.out.println(sumOfDoubleEvenPlace(number));
    System.out.println(sumOfOddPlace(number));
    JOptionPane.showMessageDialog(null,
        "the number " +
        phrase + (isValid ? " is valid": " is invalid"), "Totals", JOptionPane.PLAIN_MESSAGE);


    phrase = JOptionPane.showInputDialog(null,
    "Enter a credit card / debit card number as a long integer, Quit to end:\n",
 "Validation of Credit Card / Debit Card Numbers", JOptionPane.PLAIN_MESSAGE);
}
 }

 // Menyesuaikan prefixmatched dengan permintaan yang ada disoal
 public static boolean isValid(long number) {
    if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 6) || prefixMatched(number, 37)) {
        return (sumOfDoubleEvenPlace(number) +  sumOfOddPlace(number)) % 10 == 0;

    } else {
        return false;
    }
}

// Membuat nilai dari nomor yang genap
public static int sumOfDoubleEvenPlace(long number) {
    int sum = 0;
    int digitCount = 0;
    while (number > 0) {
        digitCount++;
        int digit = (int)(number % 10);
        if (digitCount % 2 == 0) {
            int doubleDigit = digit * 2;
            if (doubleDigit >= 10) {
                sum += 1 + doubleDigit % 10;
            } else {
                sum += doubleDigit;
            }
        }
        number /= 10;
    }
    return sum;
}

// Membuat perhitungan ketika digitnya jumlahnya 1 atau 2
public static int getDigit(int number) {
    if (number/10 == 0){
        return number;
    }
    else{
        return (number/10)+(number%10);
    }
}

// Membuat method untuk nilai pada tempat yang ganjil
public static int sumOfOddPlace(long number) {
    int sum = 0;
    int digitCount = 0;
    while (number > 0) {
        digitCount++;
        int digit = (int)(number % 10);
        if (digitCount % 2 != 0) {
            sum += digit;
        }
        number /= 10;
    }
    return sum;
}

// Method agar mendapat method getprefix
public static boolean prefixMatched(long number, int d) {
    int prefix = (int) getPrefix(number, Integer.toString(d).length());
    return prefix == d;

}

// Method untuk menentukan besar nilai dari si d
public static int getSize(long d) {
    int size = 0;
    while (d > 0) {
        size++;
        d /= 10;
    }
    return size;
}

// Method ketika ingin mendapat getprefix
public static long getPrefix(long number, int length) {
    String numStr = Long.toString(number);
    String prefixStr = numStr.substring(0, length);
    long prefix = Long.parseLong(prefixStr);
    return prefix;
}

// Membuat nilai dari number yang bernilai kebalikan
public static int reverse(int number) {
    int reverseNumber =0;
    while(number != 0)   
    {  
    int remainder = number % 10;  
    reverseNumber = reverseNumber * 10 + remainder;  
    number = number/10;  
    }  
    return reverseNumber;
}
}

