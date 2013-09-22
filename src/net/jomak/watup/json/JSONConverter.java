package net.jomak.watup.json;

public abstract class JSONConverter{
	public String queryLink="";	// The link to query the JSON data.
	/**
	 * Default constructor. Constructs a JSONConverter object.
	 */
	protected JSONConverter(){}
	
	/**
	 * Constructs a JSONConverter object with the queryLink initialized.
	 * @param queryLink The link to query.
	 */
	protected JSONConverter(String queryLink){
		this.queryLink=queryLink;
	}
	/**
	 * Creates an Object with the full JSON structure using the link that was built.
	 * @see {@link #buildQueryLink(String...)}, {@link #query(String)}
	 * @return An Object with the full JSON structure
	 */
	public Object query(){
		if (this.queryLink.trim().length()<=0)
			throw new IllegalArgumentException("The query link is blank. Please build the query link using JSONConverter.buildQueryLink()");
		return query(this.queryLink);
	}
	/**
	 * Builds the query link and sets it for later use.
	 * @param args Arguments used to build the query link.
	 * @return The built query link.
	 */
	public String buildQueryLink(String...args){
		this.queryLink=buildQuery(args);
		return this.queryLink;
	}
	/**
	 * Abstract method that builds and returns the query link from a list of arguments. 
	 * This method should NOT be public.
	 * @params args... The arguments for the query
	 * @return The final query URL.
	 */
	protected abstract String buildQuery(String... args);
	/**
	 * Creates an Object with the full JSON structure given a link to query from. (ArrayLists and Strings)
	 * @param queryLink	The link to query JSON data from.
	 * @return An Object with the full JSON structure
	 */
	protected abstract Object query (String queryLink);
}
