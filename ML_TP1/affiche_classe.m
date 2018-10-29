function affiche_classe(x,clas)
clf();
hold on;
coul=['bo';'go';'ro';'co';'mo';'yo';'ko'];
for b=1:max(clas),
ind=find(clas==b);
plot(x(1,ind),x(2,ind),coul(b,:));
end;