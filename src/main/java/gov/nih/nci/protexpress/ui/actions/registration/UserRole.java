package gov.nih.nci.protexpress.ui.actions.registration;

/**
 *
 */
public enum UserRole {

    /**
     * Curator role. 
     * CURATOR (1, "Curator", "Curator"),
     */
    /** PI role. */
    PRINCIPAL_INVESTIGATOR(2, "Principal Investigator", "PrincipalInvestigator");

    /** the id of the role. */
    private final int id;
    /** the name of the role. */
    private final String name;
    /** name of db role. */
    private final String roleName;

    /**
     * the constructor.
     */
    UserRole(int id, String name, String roleName) {
        this.id = id;
        this.name = name;
        this.roleName = roleName;
    }

    /**
     * @return db id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return display name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the db role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @return variable, in session scope.
     */
    public String getSessionVar() {
        return "is" + getRoleName();
    }
}
