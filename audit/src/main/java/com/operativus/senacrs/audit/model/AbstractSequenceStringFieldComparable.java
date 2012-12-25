package com.operativus.senacrs.audit.model;

public abstract class AbstractSequenceStringFieldComparable
		implements Comparable<AbstractSequenceStringFieldComparable> {

	protected final int sequence;

	public AbstractSequenceStringFieldComparable(final int sequence) {

		super();

		this.sequence = sequence;
	}

	public int getSequence() {

		return this.sequence;
	}

	@Override
	public int compareTo(final AbstractSequenceStringFieldComparable o) {

		int result = 0;

		if (o == null) {
			result = 1;
		} else {
			result = this.compareToNonNull(o);
		}

		return result;
	}

	private int compareToNonNull(final AbstractSequenceStringFieldComparable o) {

		int result = 0;

		result = this.getSequence() - o.getSequence();
		if (result == 0) {
			result = this.compareToSameSeqUsingStrField(o);
		}

		return result;
	}

	private int compareToSameSeqUsingStrField(final AbstractSequenceStringFieldComparable o) {

		int result = 0;

		if (this.getComparisonStringField() == null) {
			result = this.compareToThisStrFieldNull(o);
		} else if (o.getComparisonStringField() == null) {
			result = 1;
		} else {
			result = this.getComparisonStringField().compareTo(o.getComparisonStringField());
		}

		return result;
	}

	protected abstract String getComparisonStringField();

	private int compareToThisStrFieldNull(final AbstractSequenceStringFieldComparable o) {

		int result = 0;

		if (o.getComparisonStringField() == null) {
			result = 0;
		} else {
			result = -1;
		}

		return result;
	}

}
