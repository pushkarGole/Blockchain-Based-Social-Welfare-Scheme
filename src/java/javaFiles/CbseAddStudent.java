/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFiles;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 *
 * @author pushkar
 */
public class CbseAddStudent {

   public CSSS t;
    public CbseAddStudent() throws Exception {
     Web3j web3j=Web3j.build(new HttpService());
        System.out.println(web3j.web3ClientVersion().send().getWeb3ClientVersion()); 
        Credentials credentials=Credentials.create("3724f1c9b4ce6fc86cb48c26716b47b8858882df2c48e59877b3f28db1e52acf");
        t=CSSS.deploy(web3j, credentials,new BigInteger("2000000000"), new BigInteger("3000000")).send();
    //    CSSS test=CSSS.load("0x113C901871f91E1365d9621FF360791194a7Accc", web3j, credentials, new BigInteger("20000000000"), new BigInteger("3000000"));
       
    }
    
   
    public static void main(String[] args) throws Exception {
        CbseAddStudent cas=new CbseAddStudent();
        ArrayList<CBSEStudent> ar=new ArrayList<>();
        Student student;
        BankAccount account;
        Database d = new Database();
        ar=d.RetrieveTopStudents(5);
        
        for(CBSEStudent x:ar)
        {
            student = d.RetriveStudent("rollno", Integer.parseInt(x.getRollNumber()));
            account = d.RetriveBankAccount("accountNumber", student.getBankAccNumber());
            System.out.println(new BigInteger(Integer.toString(Math.round(student.getCourseMarks()))));
            System.out.println(new BigInteger("2014"));
            cas.t.addStudentToBlockchain(new BigInteger(x.getCSSSRegNumber()), new BigInteger("2014"), student.getName(), student.getCollegeID(),new BigInteger("90"), account.getBankIFSC(),student.getBankAccNumber(), student.getAddress());
        } 
    }
    
}
