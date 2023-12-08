package main

import(
    // "math"
    "fmt"
    "sort"
    "bufio"
    "strings"
    "strconv"
    "os"
) 


type hand struct{
    cards []rune
    value int
    power int 
}

func main(){

    reader := bufio.NewReader(os.Stdin)
    
    var hands[]hand

    for{

        line, _ := reader.ReadString('\n')
        if(len(line)==0){
            break
        }

        line=line[:len(line)-1]

        words:=strings.Split(line," ")
        value,_:=strconv.Atoi(words[1])
        runes:=[]rune(words[0])
        for i:=0;i<len(runes);i++{
            if(runes[i]=='T'){
                runes[i]='9'+1
            }
            if(runes[i]=='Q'){
                runes[i]='9'+3
            }
            if(runes[i]=='K'){
                runes[i]='9'+4
            }
            if(runes[i]=='A'){
                runes[i]='9'+5
            }
            if(runes[i]=='J'){
                runes[i]='1'
            }
        }
        hand1:=hand{runes,value,-1}

        hands=append(hands, hand1)
    }

    for i:=0;i<len(hands);i++{

        var multi[] int

        hand1 := hands[i]
        var runes[]rune

        for j:=0;j<len(hand1.cards);j++{
            runes = append(runes, hand1.cards[j])
        }



        sort.Slice(runes,func(i,j int)bool{return runes[i]<runes[j]})
        
        nr:=1
        ileJ:=0

        if(runes[0]=='1'){
            ileJ++
        }

        for j:=1;j<len(runes);j++{
            if(runes[j]=='1'){
                ileJ++
                nr=0
            }else if(runes[j]==runes[j-1]){
                nr++
                // fmt.Println("kutas")
            }else{
                if(runes[j-1]!='1'){

                    multi = append(multi, nr)
                }
                nr = 1
            }
        }
        multi = append(multi, nr)

        fmt.Println("ilej: ", ileJ)

        sort.Slice(multi,func(i,j int)bool{return multi[i]<multi[j]})
        multi[len(multi)-1]+=ileJ
        fmt.Println(multi)

        if multi[0]==5{
            hands[i].power=6
        }

        if len(multi)==2{
            if multi[1]==4{
                hands[i].power=5
            }else{
                hands[i].power=4
            }
        }
    
        if len(multi)==3{
            if multi[0]==multi[1] && multi[2]==3{
                hands[i].power=3
            }
            if multi[1]==multi[2]{
                hands[i].power=2
            }
        } 

        if len(multi)==4{
            hands[i].power=1
        }
        if len(multi)==5{
            hands[i].power=0
        }
    }

    sort.Slice(hands,func(i,j int)bool{
        if(hands[i].power==hands[j].power){
            for k:=0;k<len(hands[i].cards);k++{
                if(hands[i].cards[k]!=hands[j].cards[k]){



                    return hands[i].cards[k]<hands[j].cards[k]
                }
            }
        }else{
            return hands[i].power<hands[j].power
        }
        return false
    })

    for i:=0;i<len(hands);i++{
        fmt.Println(string(hands[i].cards), " ", hands[i].power, " " , hands[i].value)
    }

    wynik:=0
    for i:=0;i<len(hands);i++{
        wynik+=(i+1)*hands[i].value

    }
    fmt.Println("wynik: ", wynik)
    fmt.Println(rune('0'), " ", rune('9'))
}
// 252066447
// 241127621


