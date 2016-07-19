<% //response.sendRedirect("/signIn.htm"); %>

<h1>Welcome! Find your home </h1>
<section>
<div>
<iframe scrolling="no" allowtransparency="true" id="mainIFrame"> </iframe>

<div id="search">
        <form action="searchButtonDisplay.htm" method="get">
        	<br/>
             <input type="radio" name="category" id="category" value="Sale" checked="checked" required="required"/><span>Buy</span>
             <input type="radio" name="category" id="category" value="Rent"/><span>Rent</span>
             <br/> 
           <!--    <input type="radio" name="searchToken" id="searchToken" value="CitystateZipcode" checked="checked" required="required"/><span>City, State and Zipcode</span>
             <input type="radio" name="searchToken" id="searchToken" value="CityState"/><span>City and State</span>
             <input type="radio" name="searchToken" id="searchToken" value="zipcode"/><span>Zipcode</span> -->
             <br/>
            <input type="text" name="search_text" id="search_text" placeholder="Search your dream home (City,State,Zipcode)" required="required" title="Please Enter Valid city state or zipcode"/>
            <input type="submit" name="search_button" id="search_button" value="Search"/>
        </form>
 </div>
</div>
</section>





	


