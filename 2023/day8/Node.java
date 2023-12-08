import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Node{
  private String content;
  private String leftNode;
  private String rightNode;

  public Node (String content, String leftNode, String rightNode){
    this.content = content;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  public String getLeft(){
    return leftNode;
  }

  public String getRight(){
    return rightNode;
  }
}

