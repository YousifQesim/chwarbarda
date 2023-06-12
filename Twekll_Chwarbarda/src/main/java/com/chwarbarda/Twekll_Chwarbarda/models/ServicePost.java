package com.chwarbarda.Twekll_Chwarbarda.models;

        import jakarta.persistence.*;
        import java.util.List;

@Entity
public class ServicePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String time;
    private String postedBy;
    private String categories;
    private String comments;
    private String postTitle; // New field

    @ElementCollection
    @CollectionTable(name = "service_post_images", joinColumns = @JoinColumn(name = "service_post_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    private String postDetail;

    // getters and setters (or use Lombok annotations)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(String postDetail) {
        this.postDetail = postDetail;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    // constructors (if needed)
}
