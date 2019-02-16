#this program prints the table of the famous game minesweeper
import random
rows=int(input('Give me the number of the rows: '))
while rows<0:
	print ('The rows cannot be negative number')
	rows=int(input('Give me the number of the rows: '))
columns=int(input('Give me the number of the columns: '))
while columns<0:
	print ('The rows cannot be negative number')
	columns=int(input('Give me  columns you want to insert: '))
#now we will make a two-dimension list and we will fill it all with zeros
table1=[]
for i in range(rows):
		rows1=[]
		for j in range(columns):
			so=random.randrange(0,1);
			rows1.append(so)
		table1.append(rows1)
bombs=int(input('Give me the number of the bombs: '))
while (bombs<0 or bombs>rows*columns):
	print ('The rows cannot be negative number and bombs bigger than the dimension of the table')
	bombs=int(input('Give me the numbers of the bombs: '))
#list1=[]
#now we will put the bombs in the table.We take
# care the circumstance that no multiple bombs are in the same square
for j in range(0,bombs):
	F=False
	while F==False:
		luck1=random.randrange(0,rows)
		luck2=random.randrange(0,columns)
		if table1[luck1][luck2]!="b":
			table1[luck1][luck2]="b"
			F=True
			#we will put numbers around the bombs
			#the size number indicates the number of mines around the surroundings
			if(luck1+1>=0 and luck1+1<=rows-1 and table1[luck1+1][luck2]!="b"):
				table1[luck1+1][luck2]+=1
			if(luck1-1>=0 and luck1-1<=rows-1 and table1[luck1-1][luck2]!="b" ):
				table1[luck1-1][luck2]+=1
			if(luck2+1>=0 and luck2+1<=columns-1 and table1[luck1][luck2+1]!="b" ):
				table1[luck1][luck2+1]+=1
			if(luck2-1>=0 and luck2-1<=columns-1 and table1[luck1][luck2-1]!="b"  ):
					table1[luck1][luck2-1]+=1	
			if (luck1-1>=0 and luck2-1>=0 and luck1-1<=rows-1 and luck2-1<=columns-1 and table1[luck1-1][luck2-1]!="b" ):
				table1[luck1-1][luck2-1]+=1
			if (luck1+1>=0 and luck2-1>=0 and luck1+1<=rows-1 and luck2-1<columns-1 and table1[luck1+1][luck2-1]!="b" ):
				table1[luck1+1][luck2-1]+=1
			if (luck1-1>=0 and luck2+1>=0 and luck1-1<=rows-1 and luck2+1<=columns-1 and table1[luck1-1][luck2+1]!="b"  ):
				table1[luck1-1][luck2+1]+=1
			if (luck1+1>=0 and luck2+1>=0 and luck1+1<=rows-1 and luck2+1<columns-1 and table1[luck1+1][luck2+1]!="b" ):
				table1[luck1+1][luck2+1]+=1
#now we print the table
for xs in table1:
   print(" ".join(map(str, xs)).center(100))

	


	


  
