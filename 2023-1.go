package main

import (
    "bufio"
    "fmt"
    "os"
    "unicode"
) 

func contains(digits[]string, indx int, runes[]rune) int{
    for i:= range digits{
        size := len(digits[i])
        if(indx+size<=len(runes)){
            s:=string(runes[indx:indx+size])
            if digits[i]==s{
                return i+1
            }
        }
    }
    return -1
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    var tab [][] rune 
    var sum[] int
    digits:=[]string{"one","two","three","four","five","six","seven","eight","nine"}

    for {
        line, _ := reader.ReadString('\n')
        if len(line)==0 {
            break
        }
        runes := []rune(line)
        tab = append(tab,runes)
        // fmt.Printf(line);
    }
    for i:=0; i<len(tab); i++{
        first:=-1
        last:=-1
        for j:=0; j<len(tab[i]); j++{

            digit := tab[i][j]
            
            if unicode.IsDigit(digit){
                if first==-1{
                    first=int(digit)-'0'
                    last=int(digit)-'0'
                } else {
                    last = int(digit)-'0'
                }
                
            }else{
                result :=contains(digits,j,tab[i])
                if -1!=result{
                    if first==-1{
                        first=result
                        last=result
                    } else {
                        last = result
                    }
                }
            }
        }
        fmt.Println(first," ",last)
        sum = append(sum, first*10+last)
    }
    wynik:=0
    for i:= range sum{
        // fmt.Println(sum[i])
        wynik+=sum[i]
    }
    fmt.Print(wynik)
}
