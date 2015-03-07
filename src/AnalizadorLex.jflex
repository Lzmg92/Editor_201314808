import java_cup.runtime.Symbol;


%%

%class AnalizadorLex
%cupsym simbolo
%cup
%public
%unicode
%line
%char
%ignorecase


palabra =[a-zA-Z]+

%%
"<estructura>"      {return new Symbol(simbolo.ahtml, yychar,yyline); }
"<carpeta>"         {return new Symbol(simbolo.acarpeta, yychar,yyline); }
"<directorio>"      {return new Symbol(simbolo.adirecotorio, yychar,yyline); }
"<nombre>"          {return new Symbol(simbolo.anombre, yychar,yyline); }
"<documento>"       {return new Symbol(simbolo.adocumento, yychar,yyline); }
"<formato>"         {return new Symbol(simbolo.aformato, yychar,yyline); }
"<contenido>"       {return new Symbol(simbolo.acontenido, yychar,yyline); }

"</estructura>"      {return new Symbol(simbolo.chtml, yychar,yyline); }
"</carpeta>"         {return new Symbol(simbolo.ccarpeta, yychar,yyline); }
"</directorio>"      {return new Symbol(simbolo.cdirecotorio, yychar,yyline); }
"</nombre>"          {return new Symbol(simbolo.cnombre, yychar,yyline); }
"</documento>"       {return new Symbol(simbolo.cdocumento, yychar,yyline); }
"</formato>"         {return new Symbol(simbolo.cformato, yychar,yyline); }
"</contenido>"       {return new Symbol(simbolo.ccontenido, yychar,yyline); }

{palabra}             {return new Symbol(simbolo.palabra, yychar,yyline, new Stringyytext())); }


[ \t\r\f\n]+       { /* Se ignoran */}

.   { System.out.println("Error lexico: "+yytext()); }