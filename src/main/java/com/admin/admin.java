package com.admin;

public class admin {

	      int id;
	      String name;
	      String email;
	      String image;
	     String password;
	     
	     
		public admin(int id, String email, String name ,String password, String image) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.image = image;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return this.email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return this.password;
		}


		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getImage() {
			return this.image;
		}
		public void setImage(String img) {
			this.image = img;
		}
		
	     
	     
}
