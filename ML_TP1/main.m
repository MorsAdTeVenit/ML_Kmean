function main()
file=load('result.txt','-ascii');
x1=file(1,1:end);
x2=file(2,1:end);
x=[x1;x2];
clas=file(3,1:end);
affiche_classe(x,clas)
