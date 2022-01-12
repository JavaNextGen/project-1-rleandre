package com.revature.models;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {
	
	private int reimb_id;
	private int reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_desciption;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;

    public Reimbursement() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */
    public Reimbursement(int id, Status status, User author, User resolver, double amount) {
        super(id, status, author, resolver, amount);
    }

	public Reimbursement(int reimb_id, int reimb_amount, String reimb_submitted,
						String reimb_resolved, String reimb_desciption,
						int reimb_author, int reimb_resolver,
						int reimb_status_id, int reimb_type_id) {
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_type_id;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_desciption = reimb_desciption;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	public Reimbursement(int reimb_id, int reimb_amount, String reimb_desciption,
			int reimb_author, int reimb_resolver,
			int reimb_status_id, int reimb_type_id) {
this.reimb_id = reimb_id;
this.reimb_amount = reimb_type_id;
this.reimb_desciption = reimb_desciption;
this.reimb_author = reimb_author;
this.reimb_resolver = reimb_resolver;
this.reimb_status_id = reimb_status_id;
this.reimb_type_id = reimb_type_id;
}
	
	
	
	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public String getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_desciption() {
		return reimb_desciption;
	}

	public void setReimb_desciption(String reimb_desciption) {
		this.reimb_desciption = reimb_desciption;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
}
