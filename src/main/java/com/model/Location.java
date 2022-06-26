package com.model;

public class Location {
	private long id;
	private String email;
	private String firstName;
	private String lastName;
	private String avatar;
	private String url;
	private String text;
	
	private Location(LocationBuilder builder) {
		this.id=builder.id;
		this.email=builder.email;
		this.firstName=builder.firstName;
		this.lastName=builder.lastName;
		this.avatar=builder.avatar;
		this.url=builder.url;
		this.text=builder.text;
	}
	
	public long getId() {
		return id;
	}
		
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	/*public void setEmail(String email) {
		this.email = email;
	}*/
	public String getFirstName() {
		return firstName;
	}
	/*public void setFirstName(String firstName) {
		this.firstName = firstName;
	}*/
	public String getLastName() {
		return lastName;
	}
	/*public void setLastName(String lastName) {
		this.lastName = lastName;
	}*/
	public String getAvatar() {
		return avatar;
	}
	/*public void setAvatar(String avatar) {
		this.avatar = avatar;
	}*/
	public String getUrl() {
		return url;
	}
	/*public void setUrl(String url) {
		this.url = url;
	}*/
	public String getText() {
		return text;
	}
	/*public void setText(String text) {
		this.text = text;
	}*/
	
	public static class LocationBuilder{
		private int id;
		private String email;
		private String firstName;
		private String lastName;
		private String avatar;
		private String url;
		private String text;
		
		public LocationBuilder id(int id) {
			this.id=id;
			return this;
		}
		
		public LocationBuilder email(String email) {
			this.email=email;
			return this;
		}

		public LocationBuilder firstName(String firstName) {
			this.firstName=firstName;
			return this;
		}
		
		public LocationBuilder lastName(String lastName) {
			this.lastName=lastName;
			return this;
		}
		
		public LocationBuilder avatar(String avatar) {
			this.avatar=avatar;
			return this;
		}
		
		public LocationBuilder url(String url) {
			this.url=url;
			return this;
		}
		
		public LocationBuilder text(String text) {
			this.url=text;
			return this;
		}
		
		public Location build() {
			Location location=new Location(this);
			return location;
		}

	}
		
}
