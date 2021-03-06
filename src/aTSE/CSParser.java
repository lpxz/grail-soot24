/* Generated By:JavaCC: Do not edit this line. CSParser.java */
package aTSE;


import java.io.StringReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSParser implements CSParserConstants {


   public static List list ;
    public CSParser(String s)
    {
        this((Reader)(new StringReader(s)));
        list = new  ArrayList();
    }

    public static String loadAFileToString(String fstr) {

        BufferedReader br = null;
        String ret = null;
        try {
                File  f = new  File(fstr);
            br =  new BufferedReader(new FileReader(f));
            String line = null;
            StringBuffer sb = new StringBuffer((int)f.length());
            while( (line = br.readLine() ) != null ) {
                sb.append(line);
            }
            ret = sb.toString();
       }
        catch (Exception e) {
                        System.err.println( "reading files error");
                }
        finally {
            if(br!=null) {try{br.close();} catch(Exception e){} }
        }

        return ret;
    }
    public static void main(String args[])
    {
        try
        {

                String query = args[0];
                String truequery= loadAFileToString(query);
                CSParser parser = new CSParser(truequery);
                parser.parse();
                System.out.println(list.size());
                //[[[[Bayes, Bayes], [main], [211]], [[Yada, java, Barrier], [enterBarrier], [6]]]]
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }
    
    public static void main(String specFile)
    {
        try
        {

                String query = specFile;
                String truequery= loadAFileToString(query);
                CSParser parser = new CSParser(truequery);
                parser.parse();
             //   System.out.println(list.size());
                //[[[[Bayes, Bayes], [main], [211]], [[Yada, java, Barrier], [enterBarrier], [6]]]]
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }
    

/** 
 *  Top level
 */
  static final public void parse() throws ParseException {
    whole();
    jj_consume_token(0);
  }

/**
 * An expression is defined to be a queryTerm followed by zero or more
 * query terms joined by either an AND or an OR.   If two query terms are joined with 
 * AND then both conditions must be met.  If two query terms are joined with an OR, then
 * one of the two conditions must be met.  
 */
  static final public void whole() throws ParseException {
    equation();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      equation();
    }
  }

  static final public void equation() throws ParseException {
    jj_consume_token(STRING);
    jj_consume_token(EQUALS);
    inter();
    jj_consume_token(EOE);
  }

  static final public void inter() throws ParseException {
 List tmplist;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      tmplist = chain();
      list.add(tmplist);
      break;
    case AFTER:
      jj_consume_token(AFTER);
      chain();
      break;
    case BEFORE:
      jj_consume_token(BEFORE);
      chain();
      break;
    case BETWEEN:
      jj_consume_token(BETWEEN);
      chain();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public List chain() throws ParseException {
 List tmplist, list1, list2;
    tmplist=  new  ArrayList();
    list1 = site();
       tmplist.add(list1);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SITESEP:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(SITESEP);
      list2 = site();
        tmplist.add(list2);
    }
       {if (true) return tmplist;}
    throw new Error("Missing return statement in function");
  }

  static final public List site() throws ParseException {
 List list1, list2, tmplist;
    tmplist=  new  ArrayList();
    list1 = item();
    tmplist.add(list1);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ITEMSEP:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(ITEMSEP);
      list2 = item();
    tmplist.add(list2);
    }
       {if (true) return tmplist;}
    throw new Error("Missing return statement in function");
  }

  static final public List item() throws ParseException {
 Token str1, str2; List tmplist;
    tmplist=  new  ArrayList();
    str1 = jj_consume_token(STRING);
     tmplist.add(str1.image);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TOKENSEP:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(TOKENSEP);
      str2 = jj_consume_token(STRING);
     tmplist.add(str2.image);
    }
     {if (true) return tmplist;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CSParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000,0x3c00,0x80,0x100,0x200,};
   }

  /** Constructor with InputStream. */
  public CSParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CSParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CSParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CSParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CSParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CSParser(CSParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CSParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[14];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 5; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 14; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
