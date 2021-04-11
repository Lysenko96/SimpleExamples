
private String GET_ALL_LESSON_GROUP = "SELECT * FROM lessons_groups";

// 2 lists to map take repeat keys and make list values for it 

@Override
	public Map<Integer, List<Integer>> getAllLessonIdsGroupIds() {
		List<Integer> lessonIds = new ArrayList<>();
		List<Integer> groupIds = new ArrayList<>();
		try (Connection connection = jdbcTemplate.getDataSource().getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(GET_ALL_LESSON_GROUP);
			while (resultSet.next()) {
				lessonIds.add(resultSet.getInt("lesson_id"));
				groupIds.add(resultSet.getInt("group_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mapFromLists(lessonIds, groupIds);
	}

	Map<Integer, List<Integer>> mapFromLists(List<Integer> lessonIds, List<Integer> groupIds) {

		List<Integer> listKeys = listFromSet(lessonIds);

		List<Integer> lengths = getLengths(listKeys, lessonIds);

		List<Integer> indexes = getIndexes(listKeys, lessonIds);

		List<Integer> sortedGroupIds = getSortedGroupIds(indexes, groupIds);

		return getMap(lengths, sortedGroupIds, listKeys);
	}

	List<Integer> listFromSet(List<Integer> lessonIds) {
		Set<Integer> setKeys = new HashSet<>();
		for (Integer id : lessonIds) {
			setKeys.add(id);
		}
		return new ArrayList<>(setKeys);
	}

	List<Integer> getLengths(List<Integer> listKeys, List<Integer> lessonIds) {
		List<Integer> lengths = new ArrayList<>();
		int counterRepeat = 0;
		for (int keyIndex = 0; keyIndex < listKeys.size(); keyIndex++) {
			for (int lessonIndex = 0; lessonIndex < lessonIds.size(); lessonIndex++) {
				if (listKeys.get(keyIndex).equals(lessonIds.get(lessonIndex))) {
					counterRepeat++;
				}
			}
			lengths.add(counterRepeat);
			counterRepeat = 0;
		}
		return lengths;
	}

	List<Integer> getIndexes(List<Integer> listKeys, List<Integer> lessonIds) {
		List<Integer> indexes = new ArrayList<>();
		for (int keyIndex = 0; keyIndex < listKeys.size(); keyIndex++) {
			for (int lessonIndex = 0; lessonIndex < lessonIds.size(); lessonIndex++) {
				if (listKeys.get(keyIndex).equals(lessonIds.get(lessonIndex))) {
					indexes.add(lessonIndex);
				}
			}
		}
		return indexes;
	}

	List<Integer> getSortedGroupIds(List<Integer> indexes, List<Integer> groupIds) {
		List<Integer> sortedGroupIds = new ArrayList<>();
		for (Integer id : indexes) {
			sortedGroupIds.add(groupIds.get(id));
		}
		return sortedGroupIds;
	}

	Map<Integer, List<Integer>> getMap(List<Integer> lengths, List<Integer> sortedGroupIds, List<Integer> listKeys) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int increment = 0;
		for (int indexKey = 0; indexKey < lengths.size(); indexKey++) {
			List<Integer> values = new ArrayList<>();
			for (int indexValue = increment; indexValue < increment + lengths.get(indexKey); indexValue++) {
				values.add(sortedGroupIds.get(indexValue));
			}
			increment += lengths.get(indexKey);
			map.put(listKeys.get(indexKey), values);
		}
		return map;
	}
