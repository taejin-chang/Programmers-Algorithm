package Practice;

import java.util.Arrays;

public class phoneBookList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].length() > phone_book[i].length())
            {
                String prefix = phone_book[i + 1].substring(0,phone_book[i].length());
                if (phone_book[i].equals(prefix) == true)
                    return false;
            }
        }
        return answer;
    }
}
