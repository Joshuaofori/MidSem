import java.io.*;
public class ReadFromFile {
    int[][] datastore;//stores the read from file data into an array


    int i=0;//helps in the storing to arrays
    int leadingDiagonal;
    int trailingDiagonal;
    int j=0;
    public ReadFromFile(){
        datastore=new int[3][3];

    }
    public void readInput(){
        try {
            ReadFromUser readFromUser=new ReadFromUser();
            String read=readFromUser.takeInput();
            File file=new File(read) ;
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String input="";
            while((input=bufferedReader.readLine())!=null){
                String[] details = input.split(" ");
                datastore[i][j]= Integer.parseInt(details[0]);
                j++;
                datastore[i][j]= Integer.parseInt(details[1]);
                j++;
                datastore[i][j] = Integer.parseInt(details[2]);
       // datastore[i][j] = Integer.parseInt(input);
        j++;
        if(j==3){
            i++;
            j=0;
        }
            } }
       catch (IOException e){
            e.getMessage();
       }
    }
    public int[][] getDatastore2(){
        return datastore;
    }
    public void computediagonals(){
        leadingDiagonal=datastore[0][0]*datastore[1][1]*datastore[2][2];
        trailingDiagonal=datastore[2][0]*datastore[1][1]*datastore[0][2];

        try {
            FileWriter fileWriter = new FileWriter("ourdata.txt", true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            PrintWriter printWriter=new PrintWriter(bufferedWriter);
            bufferedWriter.newLine();
            printWriter.println(leadingDiagonal);

            printWriter.println(trailingDiagonal);

            printWriter.println(leadingDiagonal-trailingDiagonal);
            printWriter.close();
        bufferedWriter.close();
            System.out.println("succefully executed");}
        catch (IOException e){
            e.getMessage();
        }

    }
}
