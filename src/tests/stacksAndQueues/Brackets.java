package tests.stacksAndQueues;
//https://codility.com/demo/results/demoS8BDGH-AGD/
public class Brackets {
    char[] nestCharsIni = new char[]{'{','[','('};
char[] nestCharsEnd = new char[]{'}',']',')'};

public int solution(String S){
    if(S == null || S.isEmpty()) return 1;
    char[] input = S.toCharArray();
    int expectingIndex = 0;
    char[] expectingEndCharQueue = new char[input.length];
    for(char c : input) {
        boolean iniFound = false;
        boolean endFound = false;
        for(int i = 0; i<nestCharsIni.length; i++) {
            if(c == nestCharsIni[i]) {
                expectingEndCharQueue[expectingIndex++] = nestCharsEnd[i];
                iniFound = true;
                break;
            }
            else if(c == nestCharsEnd[i]) {
                if(expectingIndex == 0) return 0;
                expectingIndex--;
                if(expectingEndCharQueue[expectingIndex] != c) return 0;
                endFound = true;
                break;
            }
        }
        if(!iniFound && !endFound && expectingIndex == 0) return 0;
    }
    return expectingIndex != 0 ? 0 : 1;
}
}
