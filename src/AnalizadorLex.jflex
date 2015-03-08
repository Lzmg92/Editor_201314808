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

numero =[0-9]+ "."? [0-9]*
letra =[a-zA-ZÑñ]+
palabra ={letra}({letra}|{numero}| ":" )*




%%
"<estructura>"      {return new Symbol(simbolo.aestructura, yychar,yyline); }
"<carpeta>"         {return new Symbol(simbolo.acarpeta, yychar,yyline); }
"<directorio>"      {return new Symbol(simbolo.adirectorio, yychar,yyline); }
"<nombre>"          {return new Symbol(simbolo.anombre, yychar,yyline); }
"<documento>"       {return new Symbol(simbolo.adocumento, yychar,yyline); }
"<formato>"         {return new Symbol(simbolo.aformato, yychar,yyline); }
"<contenido>"       {return new Symbol(simbolo.acontenido, yychar,yyline); }

"</estructura>"      {return new Symbol(simbolo.cestructura, yychar,yyline); }
"</carpeta>"         {return new Symbol(simbolo.ccarpeta, yychar,yyline); }
"</directorio>"      {return new Symbol(simbolo.cdirectorio, yychar,yyline); }
"</nombre>"          {return new Symbol(simbolo.cnombre, yychar,yyline); }
"</documento>"       {return new Symbol(simbolo.cdocumento, yychar,yyline); }
"</formato>"         {return new Symbol(simbolo.cformato, yychar,yyline); }
"</contenido>"       {return new Symbol(simbolo.ccontenido, yychar,yyline); }

{palabra}             {return new Symbol(simbolo.palabra, yychar,yyline, new String(yytext())); }


[ \t\r\f\n]+       { /* Se ignoran */}

.   { System.out.println("Error lexico: "+yytext()); }

