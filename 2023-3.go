package main

import (
	"bufio"
	"fmt"
	"os"
    // "strings"
    "strconv"
)

var wynik int=0
var tab [1000][1000]rune    
var seen [1000][1000]rune    
// var tabb[10]int
func getNumber(x int,y int)int{
    _,err:=strconv.Atoi(string(tab[x][y]))
    if err!=nil || seen[x][y]==1{
        return 0
    }
    
    for{
        y++
        _,err2:=strconv.Atoi(string(tab[x][y]))
        if err2!=nil{
            break
        }
    }
    y--
    fmt.Println("start ", x , " ", y , " : " , string(tab[x][y]))
    
    number:=0
    ten:=1

    for{
        nr,err:=strconv.Atoi(string(tab[x][y]))
        if err!=nil{
            break
        }
        seen[x][y]=1
        number+=ten*nr
        ten*=10
        y--
    }
    // fmt.Println("number: ", number)
    return number
}

func around(x int,y int)int{
    var temp[]int
    wynik:=0
    wynik=getNumber(x-1,y-1)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x-1,y)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x-1,y+1)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x,y-1)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x,y+1)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x+1,y-1)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x+1,y)    
    if wynik>0{
        temp = append(temp, wynik)
    }
    wynik=getNumber(x+1,y+1)    
    if wynik>0{
        temp = append(temp, wynik)
    }


    if len(temp)==2{
        return (temp[0]*temp[1])

    }
    return 0
}

func main(){
    reader := bufio.NewReader(os.Stdin)

    for i:=0;i<1000;i++{
        for j:=0;j<1000;j++{
            tab[i][j] = rune('.')
        }
    }
    x:=0
    sizex:=0
    sizey:=0
    for {
        line, _ := reader.ReadString('\n')
        if len(line)==0 {
            break
        }
        line=line[:len(line)-1]
        sizey=len(line)

        for y:=range line{
            tab[x+1][y+1]=rune(line[y])
        }
        x++
    }
    sizex=x


    // var seen [][]rune
    // for i:=range tab{
    //     var temp[]rune
    //     for j:=range tab[i]{
    //         temp = append(temp,rune(j-j))
    //     }
    //     seen = append(seen, temp)
    // }

    fmt.Println(sizex, " : ",sizey)
    
    for i:=0;i<sizex;i++{
        for j:=0;j<sizey;j++{
            // _,err:=strconv.Atoi(string(tab[i+1][j+1]))
            if tab[i+1][j+1]==rune('*'){
                // fmt.Println("around i+1:",i+1," j+1:",j+1,": ",tab[i+1][j+1])
                wynik+=around(i+1,j+1)
            }
        }
    }
    

    fmt.Println(wynik)
}
