/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.zosbatch;

/**
 * <p>Represents a zOS Batch Job.</p>
 * 
 * @author Michael Baylis
 *
 */
public interface IZosBatchJob {
    
    /**
     * The {@link IZosBatchJobname} associated with this job
     * 
     * @return batch job name
     */
    public IZosBatchJobname getJobname();
    
    /**
     * The jobid for this Job. Returns "????????" if no jobid has been associated
     * 
     * @return batch jobid
     */
    public String getJobId();
    
    /**
     * The owner for this Job. Returns "????????" if no owner has been associated
     * 
     * @return batch job owner
     */
    public String getOwner();
    
    /**
     * The type for this Job, i.e. <code>JOB</code>, <code>STC</code> or <code>TSU</code>. Returns "???" if no type has been associated
     * 
     * @return batch job type
     */
    public String getType();

    /**
     * The batch job status, e.g.<br>
     * <code>INPUT</code>, <code>ACTIVE</code>, <code>OUTPUT</code> etc.<br>
     * Returns "????????" if the job has not been submitted
     * 
     * @return batch job status
     */
    public String getStatus();
    
    /**
     * The batch job completion return code, e.g.<br>
     * <code>CC 0000</code>, <code>CC 0020</code>, <code>JCL ERROR</code>, <code>ABEND S0C4/code> etc.<br>
     * Returns "????" if the job has not been submitted
     * 
     * @return
     */
    public String getRetcode();
    
    /**
     * Wait for a job to complete. Return the highest return code for the job. The method will wait for the default 
     * resource wait time before timing out. Returns {@link Integer.MIN_VALUE} if return code is non numeric. 
     * Use {@link #getRetcode()} to get the {@link String} value
     * 
     * @return highest CC
     * @throws ZosBatchException
     */
    public int waitForJob() throws ZosBatchException;

    /**
     * Retrieve all the output of the batch job
     * 
     * @return Lines of output
     * @throws ZosBatchException
     */
    public IZosBatchJobOutput retrieveOutput() throws ZosBatchException;
    
    /**
     * Convenience method to retrieve the content of a spool file from the batch job given the ddname.<p>
     * <b>NOTE:</b> Returns the first matching instance in the list. If the batch job has multiple steps, there may be multiple 
     * instances of the ddname. 
     * 
     * @param ddname of the spool file
     * @return the content of the first found spool file with the specified ddname
     * @throws ZosBatchException
     */
    public IZosBatchJobOutputSpoolFile getSpoolFile(String ddname) throws ZosBatchException;
    
    /**
     * Cancel the batch job
     * 
     * @throws ZosBatchException
     */
    public void cancel() throws ZosBatchException;

    /**
     * Cancel the batch job and purge output from the queue
     * 
     * @throws ZosBatchException
     */
    public void purge() throws ZosBatchException;

    /**
     * Save the job output to the Test Results Archive.<br><b>NOTE: This is done automatically if the test submitted the job.
     * 
     * @throws ZosBatchException
     */
    public void saveOutputToTestResultsArchive() throws ZosBatchException;

}
