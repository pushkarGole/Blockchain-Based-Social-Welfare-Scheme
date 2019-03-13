/*
        Document   : Database Class
        Created on : February ‎7, ‎2019, ‏‎6:52:03 AM
        Author     : Pushkar and Shivani

        This class contains various methods which performs different operations on database. 
*/
package javaFiles;

import com.google.gson.Gson;        //Mongodb Stores data in JSON document and Gson is used to create JSON object from a object of particular class
import com.google.gson.JsonSyntaxException; 
import java.util.ArrayList;
import com.mongodb.MongoCredential; 
import com.mongodb.MongoClient;
import com.mongodb.*;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.util.List;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
 
public class Database 
{  
    //This funcion insert a new student to Student collection in database 
    public void create_row(Student s)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );         //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" );     //Get the specified database
        DBCollection coll = db.getCollection("Student"); //Get the specified collection from the database    
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(s));  //Framing a Student object into a Json string and then to BasicDBObject
        coll.insert(obj);  //Insert this BasicDBObject into the Student collection
    }
    
    //This funcion insert a new course to Course collection in database 
    public void create_row(Course c)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );       //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" );     //Get the specified database
        DBCollection coll = db.getCollection("Course");  //Get the specified collection from the database   
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(c));     //Framing a Course object into a Json string and then to BasicDBObject
        coll.insert(obj);       //Insert this BasicDBObject into the Course collection
    }
   
    //This funcion insert a new Bank to Bank collection in database
    public void create_row(Bank b)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );   //Connecting to Database server    
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" );        //Get the specified database 
        DBCollection coll = db.getCollection("Bank");     //Get the specified collection from the database
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(b));  //Framing a Bank object into a Json string and then to BasicDBObject
        coll.insert(obj);   //Insert this BasicDBObject into the Bank collection
    }
    
    //This funcion insert a new Bank account to Bank account collection in database
    public void create_row(BankAccount bankAccount)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server   
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" );         //Get the specified database
        DBCollection coll = db.getCollection("BankAccount");    //Get the specified collection from the database 
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(bankAccount)); //Framing a Bank Account object into a Json string and then to BasicDBObject
        coll.insert(obj);   //Insert this BasicDBObject into the Bank collection
    }
    
    //This funcion insert a new CBSE Student to CBSE students collection in database
    public void create_row(CBSEStudent cb)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );     //Connecting to Database server  
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("CBSEStudents");    //Get the specified collection from the database  
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(cb)); //Framing a CBSE Student object into a Json string and then to BasicDBObject
        coll.insert(obj);   //Insert this BasicDBObject into the Bank collection
    }
    
    //This funcion insert a new College to College collection in database
    public void create_row(College c)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );       //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray());    //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project");  //Get the specified database
        DBCollection coll = db.getCollection("College");     //Get the specified collection from the database
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(c));  //Framing a College object into a Json string and then to BasicDBObject
        coll.insert(obj);   //Insert this BasicDBObject into the Bank collection
    }
    
    //This funcion insert a List of public addresses to Addresses collection in database
    public void create_rows(ArrayList<publicAddress> addresses)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 ); //Connecting to Database server      
        MongoCredential.createCredential("User", "major_project","password".toCharArray());  //Creating credentials to connect database 
        DB db = (DB) mongo.getDB("major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("Addresses");    //Get the specified collection from the database 
        Gson gson = new Gson();
        for (publicAddress address : addresses)     //A loop that insert each address in database one by one
        {
            BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(address));    //Framing a address object into a Json string and then to BasicDBObject
            coll.insert(obj);       //Insert this BasicDBObject into the Bank collection
        }
    }
    
    //This function updates the bank account active status 
    public void UpdateQueryBankAccount(String identify_attribute, String identify_value, String modify_attribute,boolean modify_value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );  //Connecting to Database server     
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("BankAccount");  //Get the specified collection from the database   
        BasicDBObject dbObject = new BasicDBObject();       //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(identify_attribute, identify_value); //Put the selection condition to select the rows from collection
        DBObject newObject =  coll.find(dbObject).toArray().get(0); //Find and assign the searched object to a variable newObject
        newObject.put(modify_attribute, modify_value);  //Update this newObject with modifying values against modifying attribute
        coll.findAndModify(dbObject, newObject);    //Finally update the database
    }
    
    //This function updates the CSSS registartion number of a student
    public void UpdateQueryCBSEStudent(String identify_attribute, String identify_value, String modify_attribute,String modify_value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );  //Connecting to Database server     
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("CBSE");  //Get the specified collection from the database   
        BasicDBObject dbObject = new BasicDBObject();       //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(identify_attribute, identify_value); //Put the selection condition to select the rows from collection
        DBObject newObject =  coll.find(dbObject).toArray().get(0); //Find and assign the searched object to a variable newObject
        newObject.put(modify_attribute, modify_value);  //Update this newObject with modifying values against modifying attribute
        coll.findAndModify(dbObject, newObject);    //Finally update the database
    }
    
    //This function update a public address assigned bit
    public void UpdateQueryAddress(String identify_attribute, String identify_value, String modify_attribute,boolean modify_value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );  //Connecting to Database server     
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("Addresses");  //Get the specified collection from the database   
        BasicDBObject dbObject = new BasicDBObject();       //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(identify_attribute, identify_value); //Put the selection condition to select the rows from collection
        DBObject newObject =  coll.find(dbObject).toArray().get(0); //Find and assign the searched object to a variable newObject
        newObject.put(modify_attribute, modify_value);  //Update this newObject with modifying values against modifying attribute
        coll.findAndModify(dbObject, newObject);    //Finally update the database
    }
    
    //This function updates the Student attendence in student database
    public void UpdateQueryStudent(String identify_attribute, String identify_value, String modify_attribute,float modify_value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server   
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = mongo.getDB( "major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("Student");    //Get the specified collection from the database 
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(identify_attribute, identify_value); //Put the selection condition to select the rows from collection
        DBObject newObject =  coll.find(dbObject).toArray().get(0); //Find and assign the searched object to a variable newObject
        newObject.put(modify_attribute, modify_value);  //Update this newObject with modifying values against modifying attribute
        coll.findAndModify(dbObject, newObject);       //Finally update the database
    }   
    
    //This function updates the applied status of the student for CSSS 
    public void UpdateQueryStudent(String identify_attribute, String identify_value, String modify_attribute,boolean modify_value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server   
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = mongo.getDB( "major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("Student");    //Get the specified collection from the database 
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(identify_attribute, identify_value); //Put the selection condition to select the rows from collection
        DBObject newObject =  coll.find(dbObject).toArray().get(0); //Find and assign the searched object to a variable newObject
        newObject.put(modify_attribute, modify_value);  //Update this newObject with modifying values against modifying attribute
        coll.findAndModify(dbObject, newObject);       //Finally update the database
    }
    
    //This function retrieves the top n students froom the CBSE Students database on the basis of their marks 
    public ArrayList<CBSEStudent>  RetrieveTopStudents(int n)
    {
        ArrayList<CBSEStudent> array=new ArrayList<>(); //Create a array list of CBSE students which stores the result from the database
        MongoClient mongo = new MongoClient( "localhost" , 27017 );       //Connecting to Database server 
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = (DB) mongo.getDB("major_project" ); //Get the specified database
        DBCollection coll = db.getCollection("CBSE");    //Get the specified collection from the database  
        BasicDBObject dbObject=new BasicDBObject();     //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put("appliedForCSSS",true);    //Select only those student who applied for CSSS
        DBCursor cursor = coll.find(dbObject).sort(new BasicDBObject("marks",-1)).limit(n); //Find the n rows and sort the result according to descending order of marks
        try 
        {
            while(cursor.hasNext()) 
            {
                DBObject dbobj = cursor.next();
                array.add(new Gson().fromJson(dbobj.toString(), CBSEStudent.class)); //Add the rows to array list
            }
            return array;
        } 
        catch (JsonSyntaxException e)
        {
            System.err.println(e.getMessage());
        }
        finally 
        {
            cursor.close();
            
        }
       return null;
   }
    
   //This function retrieves a student from the Student collection 
   public Student RetriveStudent(String Attribute,int value)
   {
       MongoClient mongo = new MongoClient( "localhost" , 27017 );  //Connecting to Database server    
       MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database 
       DB db = (DB) mongo.getDB("major_project" );  //Get the specified database
       DBCollection coll = db.getCollection("Student"); //Get the specified collection from the database  
       BasicDBObject dbObject = new BasicDBObject();//Create a new instance of BasicDBObject which is further used to identify the row in respective collection
       dbObject.put(Attribute,value); //Put the selection condition to select the rows from collection
       DBObject dbobj =  coll.find(dbObject).toArray().get(0);  //Fetch the result and put this to a DBObject which is further converted to Student class
       Student s = (new Gson()).fromJson(dbobj.toString(), Student.class);  //Convert DBObject to Student class using JSON String
       return s;
   }
   
   //This function retrieves a student from the CBSE Student collection
    public CBSEStudent RetriveCBSEStudent(String field_1,String value_1,String field_2,String value_2)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database 
        DB db = mongo.getDB("major_project" );  //Get the specified database
        DBCollection coll = db.getCollection("CBSE");   //Get the specified collection from the database
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(field_1,value_1);  //Put the selection condition to select the rows from collection
        dbObject.put(field_2,value_2);  //Put the selection condition to select the rows from collection
        DBObject dbobj =  coll.find(dbObject).toArray().get(0); //Fetch the result and put this to a DBObject which is further converted to CBSE Student class
        CBSEStudent s = (new Gson()).fromJson(dbobj.toString(), CBSEStudent.class); //Convert DBObject to CBSE Student class using JSON String
        return s;
    }
    
    //This function retrieves a College from the College collection 
    public College RetriveCollege(String Attribute,String value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );   //Connecting to Database server 
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database 
        DB db = mongo.getDB("major_project" );  //Get the specified database
        DBCollection coll = db.getCollection("College");    //Get the specified collection from the database
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(Attribute, value); //Put the selection condition to select the rows from collection
        DBObject dbobj =  coll.find(dbObject).toArray().get(0); //Fetch the result and put this to a DBObject which is further converted to College class
        College c = (new Gson()).fromJson(dbobj.toString(), College.class); //Convert DBObject to College class using JSON String
        return c;
    }
    
    //This function retrieves a Course from the Course collection
    public Course RetriveCourse(String Attribute,String value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray()); //Creating credentials to connect database  
        DB db = mongo.getDB("major_project" );  //Get the specified database
        DBCollection coll = db.getCollection("Course"); //Get the specified collection from the database
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(Attribute, value);     //Put the selection condition to select the rows from collection
        DBObject dbobj =  coll.find(dbObject).toArray().get(0); //Fetch the result and put this to a DBObject which is further converted to Course class
        Course c = (new Gson()).fromJson(dbobj.toString(), Course.class);   //Convert DBObject to Course class using JSON String
        return c;
    }
    
    //This function retrieves a Bank from the Bank collection
    public Bank RetriveBank(String Attribute,String value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database  
        DB db = mongo.getDB("major_project" );      //Get the specified database
        DBCollection coll = db.getCollection("Bank");   //Get the specified collection from the database
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(Attribute, value); //Put the selection condition to select the rows from collection
        DBObject dbobj =  coll.find(dbObject).toArray().get(0); //Fetch the result and put this to a DBObject which is further converted to Bank class
        Bank bank = (new Gson()).fromJson(dbobj.toString(), Bank.class);    //Convert DBObject to Bank class using JSON String
        return bank;
    }
    
    //This function retrieves a Bankaccount from the Bankaccount collection
    public BankAccount RetriveBankAccount(String Attribute,String value)
    {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );    //Connecting to Database server
        MongoCredential.createCredential("User", "major_project","password".toCharArray());   //Creating credentials to connect database
        DB db = mongo.getDB("major_project" );      //Get the specified database
        DBCollection coll = db.getCollection("BankAccount");    //Get the specified collection from the database
        BasicDBObject dbObject = new BasicDBObject();   //Create a new instance of BasicDBObject which is further used to identify the row in respective collection
        dbObject.put(Attribute, value); //Put the selection condition to select the rows from collection
        DBObject dbobj =  coll.find(dbObject).toArray().get(0);//Fetch the result and put this to a DBObject which is further converted to Bankaccount class
        BankAccount bankAccount = (new Gson()).fromJson(dbobj.toString(), BankAccount.class);   //Convert DBObject to Bank class using JSON String
        return bankAccount;
    }
     
}
