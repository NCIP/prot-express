function  WWHBookData_AddIndexEntries(P)
{
var A=P.fA("A",null,null,"002");
var B=A.fA("Application Support, FIREBIRD",new Array("17#1069150"));
A=P.fA("N",null,null,"002");
B=A.fA("NCICB Application Support",new Array("17#1069150"));
A=P.fA("O",null,null,"002");
B=A.fA("Online help");
var C=B.fA("locating topics of interest",new Array("1#1087423"));
C=B.fA("printing",new Array("1#1087448"));
C=B.fA("using",new Array("1"));
C=B.fA("using navigation tools",new Array("1#1087438"));
C=B.fA("viewing table of contents",new Array("1#1087428"));
}

function  WWHBookData_MaxIndexLevel()
{
  return 3;
}
