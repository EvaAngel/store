package com.store.domain;

import java.sql.Date;

public class User
{
   private String id;
   private String username;
   private String password;
   private String email;
   private String sex;
   private String name;
   private Date birthday;
   private String telephone;
   private int activecode;
   private String activestatus;
public String getId()
{
	return id;
}
public void setId(String id)
{
	this.id = id;
}
public String getUsername()
{
	return username;
}
public void setUsername(String username)
{
	this.username = username;
}
public String getPassword()
{
	return password;
}
public void setPassword(String password)
{
	this.password = password;
}
public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email = email;
}
public String getSex()
{
	return sex;
}
public void setSex(String sex)
{
	this.sex = sex;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}
public Date getBirthday()
{
	return birthday;
}
public void setBirthday(Date birthday)
{
	this.birthday = birthday;
}
public String getTelephone()
{
	return telephone;
}
public void setTelephone(String telephone)
{
	this.telephone = telephone;
}
public int getActivecode()
{
	return activecode;
}
public void setActivecode(int activecode)
{
	this.activecode = activecode;
}
public String getActivestatus()
{
	return activestatus;
}
public void setActivestatus(String activestatus)
{
	this.activestatus = activestatus;
}
@Override
public String toString()
{
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", sex=" + sex
			+ ", name=" + name + ", birthday=" + birthday + ", telephone=" + telephone + ", activecode=" + activecode
			+ ", activestatus=" + activestatus + "]";
}

}
