package com.ReusableFunc;

import com.model.Location;

public class ReusableFunction {
		
	public Location createLocationData(int id,
			String email,String firstName,
			String lastName,String avatar,
			String url,String text) {
		return new Location.LocationBuilder().id(20)
				.email(email)
				.firstName(firstName)
				.lastName(lastName)
				.avatar(avatar)
				.url(url)
				.text(text)
				.build();
	}
}
