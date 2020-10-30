package com.test.entity;

public class Book {
    private String name;
    private int year;
    
    public Book() {
	}

	public Book(String name, int year) {
		super();
		this.name = name;
		this.year = year;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

	@Override
	public String toString() {
		return "Book [name=" + name + ", year=" + year + "]";
	}
    
}