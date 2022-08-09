<html>
<body>
	<h2>Dispatcher Recipe</h2>
	<form action="dispatcherRecipe" method="post">
		<fieldset>
			<label>Select recipe</label>
			<p>
				<input type="radio" value="omelette" name="recipe"
					required="required">omelette<br>
			</p>
			<p>
				<input type="radio" value="fruit salad" name="recipe"
					required="required">fruit salad<br>
			</p>
			<p>
				<input type="radio" value="vegetables salad" name="recipe"
					required="required">vegetables salad<br>
			</p>
		</fieldset>
		<button type="submit">Check Shopping List</button>
	</form>
</body>
</html>