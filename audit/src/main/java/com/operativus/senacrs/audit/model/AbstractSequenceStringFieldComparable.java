package com.operativus.senacrs.audit.model;

public abstract class AbstractSequenceStringFieldComparable
		implements Comparable<AbstractSequenceStringFieldComparable> {

	protected final int sequence;

	public AbstractSequenceStringFieldComparable(int sequence) {

		super();

		this.sequence = sequence;
	}

	public int getSequence() {

		return sequence;
	}

	@Override
	public int compareTo(AbstractSequenceStringFieldComparable o) {

		int result = 0;

		if (o == null) {
			result = 1;
		} else {
			result = compareToNonNull(o);
		}

		return result;
	}

	private int compareToNonNull(AbstractSequenceStringFieldComparable o) {

		int result = 0;

		result = this.getSequence() - o.getSequence();
		if (result == 0) {
			result = compareToSameSeqUsingStrField(o);
		}

		return result;
	}

	private int compareToSameSeqUsingStrField(AbstractSequenceStringFieldComparable o) {

		int result = 0;

		if (this.getComparisonStringField() == null) {
			result = compareToThisStrFieldNull(o);
		} else if (o.getComparisonStringField() == null) {
			result = 1;
		} else {
			result = this.getComparisonStringField().compareTo(o.getComparisonStringField());
		}

		return result;
	}

	protected abstract String getComparisonStringField();

	private int compareToThisStrFieldNull(AbstractSequenceStringFieldComparable o) {

		int result = 0;

		if (o.getComparisonStringField() == null) {
			result = 0;
		} else {
			result = -1;
		}

		return result;
	}

}
