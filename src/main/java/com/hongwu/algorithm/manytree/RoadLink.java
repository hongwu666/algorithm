package com.hongwu.algorithm.manytree;

import java.util.ArrayList;
import java.util.List;

class RoadLink {
	Integer data;

	/// 子节点
	List<Integer> subRoads = null;

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public List<Integer> getSubRoads() {
		return subRoads;
	}

	public void setSubRoads(List<Integer> subRoads) {
		this.subRoads = subRoads;
	}

	public RoadLink() {
	}

	public RoadLink(Integer data) {
		this.data = data;
	}

	public void AddSubRoad(Integer subRoad) {
		if (subRoads == null)
			subRoads = new ArrayList<Integer>();
		if (subRoads.contains(subRoad))
			subRoads.add(subRoad);
	}
}