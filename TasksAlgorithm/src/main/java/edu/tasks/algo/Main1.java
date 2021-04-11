
private String GET_ALL_LESSON_GROUP = "SELECT * FROM lessons_groups";

// 2 lists to map take repeat keys and make list values for it 

@Override
	public Map<Integer, List<Integer>> getAllLessonIdsGroupIds() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> lessonIds = new ArrayList<>();
		List<Integer> groupIds = new ArrayList<>();
		try (Connection connection = jdbcTemplate.getDataSource().getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(GET_ALL_LESSON_GROUP);
			while (resultSet.next()) {
				lessonIds.add(resultSet.getInt("column_id"));
				groupIds.add(resultSet.getInt("column2_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Set<Integer> setKeys = new HashSet<>();
		for (Integer id : lessonIds) {
			setKeys.add(id);
		}
		List<Integer> lengths = new ArrayList<>();
		int counterRepeat = 0;
		List<Integer> listKeys = new ArrayList<>(setKeys);
		for (int keyIndex = 0; keyIndex < listKeys.size(); keyIndex++) {
			for (int lessonIndex = 0; lessonIndex < lessonIds.size(); lessonIndex++) {
				if (listKeys.get(keyIndex).equals(lessonIds.get(lessonIndex))) {
					counterRepeat++;
				}
			}
			lengths.add(counterRepeat);
			counterRepeat = 0;
		}
		int increment = 0;
		for (int indexKey = 0; indexKey < lengths.size(); indexKey++) {
			List<Integer> values = new ArrayList<>();
			for (int indexValue = increment; indexValue < increment + lengths.get(indexKey); indexValue++) {
				values.add(groupIds.get(indexValue));
			}
			increment += lengths.get(indexKey);
			map.put(indexKey + 1, values);
		}
		return map;
	}
